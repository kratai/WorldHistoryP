package com.example.admin.worldhistoryp;

public class Gobal {
    private static Gobal instance;

    private int sum;

    private Gobal() {
    }

    public void setSum(int a)
    {
        this.sum = a;
    }

    public int getSum()
    {
        return this.sum;
    }
    public static synchronized Gobal getInstance()
    {
        if(instance == null)
        {
            instance = new Gobal();
        }
        return instance;
    }




}

