package com.lin.util;

import stormpot.Allocator;
import stormpot.Pool;
import stormpot.Slot;
import stormpot.Timeout;

import java.util.concurrent.TimeUnit;

public class DataloaderPool implements Allocator<DataloaderInterface> {
    String jsPath;
    Pool<DataloaderInterface> pool;
    Timeout timeout = new Timeout(1, TimeUnit.SECONDS);

    public DataloaderPool(String path) {
        this.jsPath = path;
        pool = Pool.from(this).build();
    }

    @Override
    public DataloaderInterface allocate(Slot slot) throws Exception {
        return new AnotherJsDataLoader(slot);
    }

    @Override
    public void deallocate(DataloaderInterface dataloaderInterface) throws Exception {
        dataloaderInterface.destory();
    }

    public DataloaderInterface claim(){
        try {
            return  pool.claim(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
