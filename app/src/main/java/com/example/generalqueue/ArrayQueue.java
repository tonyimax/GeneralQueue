package com.example.generalqueue;

import android.content.Context;
import android.widget.Toast;

import java.util.Arrays;

public class ArrayQueue {
    private int capacity;//队列容量
    private int front;//队头
    private int rear;//队尾
    private int[] queue_data;//队列容器
    private final Context _context;

    //构造
    public ArrayQueue(Context _ctx){
        _context=_ctx;
        capacity=100;//默认队列大小
        initQueue();//初始化队列
    }

    //构造
    public ArrayQueue(int queue_capacity, Context _ctx){
        _context=_ctx;
        capacity = queue_capacity;
        initQueue();//初始化队列
    }

    //初始化队列
    private void initQueue(){
        queue_data = new int[capacity];//初始化队列容器
        front=-1;//初始化队头
        rear=-1;//初始化队尾
    }

    //清空队列
    public void clean(){
        Arrays.fill(queue_data,0);//重置数组
        front=-1;//初始化队头
        rear=-1;//初始化队尾
    }

    //队列容量
    public int Capacity(){
        return capacity;
    }

    //队列当前大小
    public int Count(){
        return rear-front;
    }

    //满队
    public boolean isFull() {
           return rear==capacity-1;
    };

    //空队
    public boolean isEmpty(){
        return front==rear;
    }

    //获取队头
    public int getFront(){
        return front;
    }

    //获取队尾
    public int getRear()
    {
        return rear;
    }

    //入队
    public void enqueue(int data){
        if (isFull()){
            System.out.println("队列已满");
            Toast.makeText(_context,"队列已满",Toast.LENGTH_LONG).show();
        }else{
            rear++;
            queue_data[rear]=data;
            System.out.println("入队:"+queue_data[rear]);
        }
    }

    //出队
    public int dequeue(){
        if (isEmpty()){
            System.out.println("队列为空，无法出队");
            Toast.makeText(_context,"队列为空，无法出队",Toast.LENGTH_LONG).show();
            return -1;
        }else {
            front++;
            int data = queue_data[front];
            System.out.println("<<<出队: "+data);
            queue_data[front]=0;
            adjustQueue();
            return data;
        }
    }

    //出队后重新调整队列
    private void adjustQueue(){
        int len = rear-front;
        int[] tmpQueue = new int[len];
        System.arraycopy(queue_data,front+1,tmpQueue,0,len);
        Arrays.fill(queue_data,0);
        System.arraycopy(tmpQueue,0,queue_data,0,len);
        front--;
        rear--;
        System.out.println("<<<成功调整队列： front："+front+"rear: "+rear);
    }

}
