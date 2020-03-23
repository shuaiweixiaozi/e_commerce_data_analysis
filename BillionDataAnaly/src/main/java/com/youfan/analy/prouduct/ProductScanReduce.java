package com.youfan.analy.prouduct;

import com.youfan.analyEntity.conpus.ConpusanalyEntity;
import com.youfan.analyEntity.productscan.ProductanalyEntity;
import org.apache.flink.api.common.functions.ReduceFunction;

public class ProductScanReduce implements ReduceFunction<ProductanalyEntity>{
    @Override
    public ProductanalyEntity reduce(ProductanalyEntity productanalyEntity, ProductanalyEntity t1) throws Exception {
        String groupField =  productanalyEntity.getGroupField();
        Long times1 = productanalyEntity.getTimes();

        Long Times2 = t1.getTimes();

        ProductanalyEntity productanalyEntity1 = new ProductanalyEntity();
        productanalyEntity1.setGroupField(groupField);
        productanalyEntity1.setTimes(times1+Times2);
        return productanalyEntity1;
    }
}
