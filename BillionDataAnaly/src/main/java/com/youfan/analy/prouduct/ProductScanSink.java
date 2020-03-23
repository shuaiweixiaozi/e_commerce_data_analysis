package com.youfan.analy.prouduct;

import com.youfan.analyEntity.conpus.ConpusanalyEntity;
import com.youfan.analyEntity.productscan.ProductanalyEntity;
import com.youfan.utils.HbaseUtil2;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

/**
 * create "userTheme","productscan"
 */
public class ProductScanSink implements SinkFunction<ProductanalyEntity>{
    @Override
    public void invoke(ProductanalyEntity value) throws Exception {
        String tableName = "userTheme";
        String cloumnFamliy = "productscan";
        String groupField = value.getGroupField();
        String[] temp = groupField.split("==");
        String userId = temp[0];
        String productId = temp[1];
        Long times = value.getTimes();

        String productscanTimes = HbaseUtil2.getdata(tableName,groupField,cloumnFamliy,"times");
        if(StringUtils.isBlank(productscanTimes)){
            HbaseUtil2.putdata(tableName,groupField,cloumnFamliy,"times",times+"");
        }else{
            HbaseUtil2.putdata(tableName,groupField,cloumnFamliy,"times",(Long.valueOf(productscanTimes)+times)+"");
        }
        String productnum = HbaseUtil2.getdata(tableName,groupField,cloumnFamliy,"times");
        String maxproduct = HbaseUtil2.getdata(tableName,userId,cloumnFamliy,"maxtimes");
        String preTotaltimesString = HbaseUtil2.getdata(tableName,userId,cloumnFamliy,"totaltimes");
        long preTotaltimes = StringUtils.isBlank(preTotaltimesString)?0L:Long.valueOf(preTotaltimesString);
        HbaseUtil2.putdata(tableName,userId,cloumnFamliy,"totaltimes",(preTotaltimes+times)+"");
        if(StringUtils.isBlank(maxproduct)||Long.valueOf(productnum)>Long.valueOf(maxproduct)){

            HbaseUtil2.putdata(tableName,groupField,cloumnFamliy,"maxtimes",productnum);
            HbaseUtil2.putdata(tableName,groupField,cloumnFamliy,"maxproductId",productId);
        }
    }
}
