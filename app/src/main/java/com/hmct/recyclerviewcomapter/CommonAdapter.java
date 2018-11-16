package com.hmct.recyclerviewcomapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder>
{
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    protected OnItemClickListener mOnItemClickListener;


    public CommonAdapter(Context context, int layoutId, List<T> datas)
    {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType)
    {
        final ViewHolder viewHolder = ViewHolder.get(mContext, parent, mLayoutId);

        setListener(parent, viewHolder, viewType);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {
//        holder.updatePosition(position);
        convert(holder, mDatas.get(position));

    }

    public abstract void convert(ViewHolder holder, T t);

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }


    protected void setListener(final ViewGroup parent, final ViewHolder viewHolder, int viewType) {
//        if (!isEnabled(viewType)) return;
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = viewHolder.getAdapterPosition();
                    mOnItemClickListener.onItemClick(v, viewHolder , position);
                }
            }
        });

        viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = viewHolder.getAdapterPosition();
                    return mOnItemClickListener.onItemLongClick(v, viewHolder, position);
                }
                return false;
            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(View view, RecyclerView.ViewHolder holder, int position);

        boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position);
    }

    //需要调用
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
