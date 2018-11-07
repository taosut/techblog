package com.bloglaptrinh.app.elasticsearch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.script.mustache.SearchTemplateRequestBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.elasticsearch.search.aggregations.bucket.histogram.Histogram;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.avg.Avg;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BaseDemo {
    private static final Logger logger = LogManager.getLogger(BaseDemo.class);

    @SuppressWarnings({"unchecked", "resource"})
    public static void main(String[] args) throws IOException {
        // æ?clientC?¢Qª?¥Fcluster.name ÅèQã\@ÊQIÜ?CWQ¼Ì
        // client.transport.sniff \¦?u©?T?WQIWQ?_
        Settings settings = Settings.builder()
                .put("cluster.name", "youmeek-cluster")
                .put("client.transport.sniff", true)
                .build();

        //?¢?_IÊ@
        //TransportClient transportClient = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.1.127"), 9300));
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        //======================================================

        //create(transportClient);
        batchCreate(transportClient);
        //batchUpdate(transportClient);
        //batchDelete(transportClient);
        //update(transportClient);
        query(transportClient);
        //queryByMatchOneParam(transportClient);
        /*queryByMatchMoreParam(transportClient);
        queryByTerm(transportClient);
        queryByPrefix(transportClient);
        queryByBool(transportClient);
        queryMore(transportClient);
        queryByMultiGet(transportClient);
        queryByScroll(transportClient);
        queryByTemplate(transportClient);
        delete(transportClient);
        aggregate(transportClient);*/

        //======================================================

        transportClient.close();
    }


    /**
     * ?
     *
     * @param transportClient
     */
    private static void create(TransportClient transportClient) throws IOException {
        IndexResponse indexResponse = transportClient.prepareIndex("product_index", "product", "1").setSource(XContentFactory.jsonBuilder()
                .startObject()
                .field("product_name", "?Y??åü HX6700-1")
                .field("product_desc", "O 1000 ¼?ü?C6  1 ú 0 _Î??C618 ????ô 48 ¬?")
                .field("price", 399.00)
                .field("created_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                .field("last_modified_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                .field("version", 1)
                .endObject()).get();

        IndexResponse indexResponse2 = transportClient.prepareIndex("product_index", "product", "2").setSource(XContentFactory.jsonBuilder()
                .startObject()
                .field("product_name", "?Y??åü HX6700-2")
                .field("product_desc", "O 1000 ¼?ü?C6  1 ú 0 _Î??C618 ????ô 48 ¬?")
                .field("price", 399.00)
                .field("created_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                .field("last_modified_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                .field("version", 1)
                .endObject()).get();

        IndexResponse indexResponse3 = transportClient.prepareIndex("product_index", "product", "3").setSource(XContentFactory.jsonBuilder()
                .startObject()
                .field("product_name", "?Y??åü HX6700-3")
                .field("product_desc", "O 1000 ¼?ü?C6  1 ú 0 _Î??C618 ????ô 48 ¬?")
                .field("price", 399.00)
                .field("created_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                .field("last_modified_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                .field("version", 1)
                .endObject()).get();

        IndexResponse indexResponse4 = transportClient.prepareIndex("product_index", "product", "4").setSource(XContentFactory.jsonBuilder()
                .startObject()
                .field("product_name", "?Y??åü HX6700-4")
                .field("product_desc", "O 1000 ¼?ü?C6  1 ú 0 _Î??C618 ????ô 48 ¬?")
                .field("price", 399.00)
                .field("created_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                .field("last_modified_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                .field("version", 1)
                .endObject()).get();

        IndexResponse indexResponse5 = transportClient.prepareIndex("product_index", "product", "5").setSource(XContentFactory.jsonBuilder()
                .startObject()
                .field("product_name", "?Y??åü HX6700-5")
                .field("product_desc", "O 1000 ¼?ü?C6  1 ú 0 _Î??C618 ????ô 48 ¬?")
                .field("price", 399.00)
                .field("created_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                .field("last_modified_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                .field("version", 1)
                .endObject()).get();
    }

    /**
     * áÊ?
     *
     * @param transportClient
     */
    private static void batchCreate(TransportClient transportClient) throws IOException {
        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();

        IndexRequestBuilder indexRequestBuilder1 = transportClient.prepareIndex("product_index", "product", "1")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("product_name", "?Y??åü HX6700-1")
                        .field("product_desc", "O 1000 ¼?ü?C6  1 ú 0 _Î??C618 ????ô 48 ¬?")
                        .field("price", 399.00)
                        .field("created_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                        .field("last_modified_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                        .field("version", 1)
                        .endObject());

        IndexRequestBuilder indexRequestBuilder2 = transportClient.prepareIndex("product_index", "product", "2")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("product_name", "?Y??åü HX6700-2")
                        .field("product_desc", "O 1000 ¼?ü?C6  1 ú 0 _Î??C618 ????ô 48 ¬?")
                        .field("price", 399.00)
                        .field("created_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                        .field("last_modified_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                        .field("version", 1)
                        .endObject());

        IndexRequestBuilder indexRequestBuilder3 = transportClient.prepareIndex("product_index", "product", "3")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("product_name", "?Y??åü HX6700-3")
                        .field("product_desc", "O 1000 ¼?ü?C6  1 ú 0 _Î??C618 ????ô 48 ¬?")
                        .field("price", 399.00)
                        .field("created_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                        .field("last_modified_date_time", new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ").format(new Date()))
                        .field("version", 1)
                        .endObject());


        bulkRequestBuilder.add(indexRequestBuilder1);
        bulkRequestBuilder.add(indexRequestBuilder2);
        bulkRequestBuilder.add(indexRequestBuilder3);

        BulkResponse bulkResponse = bulkRequestBuilder.get();
        for (BulkItemResponse bulkItemResponse : bulkResponse.getItems()) {
            logger.info("--------------------------------version= " + bulkItemResponse.getVersion());
        }
    }

    /**
     * áÊXV
     *
     * @param transportClient
     */
    private static void batchUpdate(TransportClient transportClient) throws IOException {
        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();

        UpdateRequestBuilder updateRequestBuilder1 = transportClient.prepareUpdate("product_index", "product", "1")
                .setDoc(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("product_name", "XV@I¤i¼Ì1")
                        .endObject());

        UpdateRequestBuilder updateRequestBuilder2 = transportClient.prepareUpdate("product_index", "product", "2")
                .setDoc(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("product_name", "XV@I¤i¼Ì2")
                        .endObject());

        UpdateRequestBuilder updateRequestBuilder3 = transportClient.prepareUpdate("product_index", "product", "3")
                .setDoc(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("product_name", "XV@I¤i¼Ì3")
                        .endObject());


        bulkRequestBuilder.add(updateRequestBuilder1);
        bulkRequestBuilder.add(updateRequestBuilder2);
        bulkRequestBuilder.add(updateRequestBuilder3);

        BulkResponse bulkResponse = bulkRequestBuilder.get();
        for (BulkItemResponse bulkItemResponse : bulkResponse.getItems()) {
            logger.info("--------------------------------version= " + bulkItemResponse.getVersion());
        }
    }

    /**
     * áÊ?
     *
     * @param transportClient
     */
    private static void batchDelete(TransportClient transportClient) throws IOException {
        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();

        DeleteRequestBuilder deleteRequestBuilder1 = transportClient.prepareDelete("product_index", "product", "1");
        DeleteRequestBuilder deleteRequestBuilder2 = transportClient.prepareDelete("product_index", "product", "2");
        DeleteRequestBuilder deleteRequestBuilder3 = transportClient.prepareDelete("product_index", "product", "3");

        bulkRequestBuilder.add(deleteRequestBuilder1);
        bulkRequestBuilder.add(deleteRequestBuilder2);
        bulkRequestBuilder.add(deleteRequestBuilder3);

        BulkResponse bulkResponse = bulkRequestBuilder.get();
        for (BulkItemResponse bulkItemResponse : bulkResponse.getItems()) {
            logger.info("--------------------------------version= " + bulkItemResponse.getVersion());
        }

    }

    /**
     * ?æ?¢?ÛiIDj
     *
     * @param transportClient
     * @throws IOException
     */
    private static void query(TransportClient transportClient) throws IOException {
        GetResponse getResponse = transportClient.prepareGet("product_index", "product", "1").get();
        logger.info("--------------------------------F" + getResponse.getSourceAsString());
    }

    /**
     * ?? match ?¢i
     *
     * @param transportClient
     * @throws IOException
     */
    private static void queryByMatchOneParam(TransportClient transportClient) throws IOException {
        SearchResponse searchResponse = transportClient.prepareSearch("product_index").setTypes("product")
                .setQuery(QueryBuilders.matchQuery("product_name", "?Y"))
                .get();

        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
            logger.info("--------------------------------F" + searchHit.getSourceAsString());
        }
    }

    /**
     * ?? match ½¢i
     *
     * @param transportClient
     * @throws IOException
     */
    private static void queryByMatchMoreParam(TransportClient transportClient) throws IOException {
        SearchResponse searchResponse = transportClient.prepareSearch("product_index").setTypes("product")
                .setQuery(QueryBuilders.multiMatchQuery("?Y", "product_name", "product_desc"))
                .get();

        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
            logger.info("--------------------------------F" + searchHit.getSourceAsString());
        }
    }

    /**
     * ?? term
     *
     * @param transportClient
     * @throws IOException
     */
    private static void queryByTerm(TransportClient transportClient) throws IOException {
        SearchResponse searchResponse = transportClient.prepareSearch("product_index").setTypes("product")
                .setQuery(QueryBuilders.termQuery("product_name.keyword", "?Y"))
                .get();

        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
            logger.info("--------------------------------F" + searchHit.getSourceAsString());
        }
    }

    /**
     * ?? prefix
     *
     * @param transportClient
     * @throws IOException
     */
    private static void queryByPrefix(TransportClient transportClient) throws IOException {
        SearchResponse searchResponse = transportClient.prepareSearch("product_index").setTypes("product")
                .setQuery(QueryBuilders.prefixQuery("product_name", "?"))
                .get();

        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
            logger.info("--------------------------------F" + searchHit.getSourceAsString());
        }
    }

    /**
     * ?? bool
     *
     * @param transportClient
     * @throws IOException
     */
    private static void queryByBool(TransportClient transportClient) throws IOException {
        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery("product_name", "?Y"))
                .should(QueryBuilders.rangeQuery("created_date_time").gte("2017-01-01").lte("2017-12-31"))
                .filter(QueryBuilders.rangeQuery("price").gte(150).lte(400));

        SearchResponse searchResponse = transportClient.prepareSearch("product_index").setTypes("product")
                .setQuery(queryBuilder)
                .get();

        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
            logger.info("--------------------------------F" + searchHit.getSourceAsString());
        }
    }

    /**
     * ?æ½¢?ÛiªIDj
     *
     * @param transportClient
     * @throws IOException
     */
    private static void queryByMultiGet(TransportClient transportClient) throws IOException {

        MultiGetResponse multiGetItemResponses = transportClient.prepareMultiGet()
                .add("product_index", "product", "1")
                .add("product_index", "product", "2")
                .add("product_index", "product", "3")
                .add("product_index", "product", "4")
                .add("product_index", "product", "5")
                .get();

        String resultJSON = null;
        for (MultiGetItemResponse multiGetItemResponse : multiGetItemResponses) {
            GetResponse getResponse = multiGetItemResponse.getResponse();
            if (getResponse.isExists()) {
                resultJSON = getResponse.getSourceAsString();
            }
        }
        logger.info("--------------------------------F" + resultJSON);
    }

    /**
     * Scroll ?æ½¢?Û
     *
     * @param transportClient
     * @throws IOException
     */
    private static void queryByScroll(TransportClient transportClient) throws IOException {

        //setSize ¥?u?á??½­ð
        SearchResponse searchResponse = transportClient.prepareSearch("product_index").setTypes("product")
                .setQuery(QueryBuilders.termQuery("product_name", "?Y"))
                .setScroll(new TimeValue(60000))
                .setSize(3)
                .get();

        int count = 0;

        do {
            for (SearchHit searchHit : searchResponse.getHits().getHits()) {
                //Åó???ÊC½Òô´¼?
                logger.info("count=" + ++count);
                logger.info(searchHit.getSourceAsString());
            }

            searchResponse = transportClient.prepareSearchScroll(searchResponse.getScrollId()).setScroll(new TimeValue(60000))
                    .execute()
                    .actionGet();
        } while (searchResponse.getHits().getHits().length != 0);
    }

    /**
     * Ê?ÍÂ¶?s??
     *
     * @param transportClient
     * @throws IOException
     */
    private static void queryByTemplate(TransportClient transportClient) throws IOException {
        //ÍÂ¶ùvúÝFElasticsearch ÀÚ?ºIFconfig/scripts Ú?ºCä@äLê¢Fquery_template_1.mustache
        //????ÍÂCQ¥Â?ICÍÂàe@ºB
		/*
		{
			"from": {{from}},
			"size": {{size}},
			"query": {
				"match": {
					"product_name": "{{product_name}}"
				}
			}
		}
		*/

        Map<String, Object> scriptParams = new HashMap<String, Object>();
        scriptParams.put("from", 0);
        scriptParams.put("size", 10);
        scriptParams.put("product_name", "?Y");

        SearchResponse searchResponse = new SearchTemplateRequestBuilder(transportClient)
                .setScript("query_template_1")
                .setScriptType(ScriptType.INLINE)
                .setScriptParams(scriptParams)
                .setRequest(new SearchRequest("product_index").types("product"))
                .get()
                .getResponse();

        for (SearchHit searchHit : searchResponse.getHits().getHits()) {
            logger.info("--------------------------------F" + searchHit.getSourceAsString());
        }
    }

    /**
     * Cü
     *
     * @param transportClient
     * @throws IOException
     */
    private static void update(TransportClient transportClient) throws IOException {
        UpdateResponse updateResponse = transportClient.prepareUpdate("product_index", "product", "1")
                .setDoc(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("product_name", "?Y??åü HX6700 £??¨")
                        .endObject())
                .get();
        logger.info("--------------------------------F" + updateResponse.getResult());

    }

    /**
     * ?
     *
     * @param transportClient
     * @throws IOException
     */
    private static void delete(TransportClient transportClient) throws IOException {
        DeleteResponse deleteResponse = transportClient.prepareDelete("product_index", "product", "1").get();
        logger.info("--------------------------------F" + deleteResponse.getResult());
    }

    //============================================================================================================

    /**
     * ½¢ð??
     *
     * @param transportClient
     * @throws IOException
     */
    private static void queryMore(TransportClient transportClient) throws IOException {
        SearchResponse searchResponse = transportClient.prepareSearch("product_index").setTypes("product")
                .setQuery(QueryBuilders.matchQuery("product_name", "?Y"))
                .setPostFilter(QueryBuilders.rangeQuery("price").from(300).to(400))
                .setFrom(0).setSize(1)
                .get();

        SearchHit[] searchHits = searchResponse.getHits().getHits();
        for (int i = 0; i < searchHits.length; i++) {
            logger.info("--------------------------------F" + searchHits[i].getSourceAsString());
        }
    }

    //============================================================================================================

    /**
     * ãÚªÍ
     * 1. æª?
     * 2. qª?
     * 3. Å@Zoqª?I½Ï?
     *
     * @param transportClient
     * @throws IOException
     */
    private static void aggregate(TransportClient transportClient) throws IOException {

        SearchResponse searchResponse = transportClient.prepareSearch("product_index").setTypes("product")
                .addAggregation(AggregationBuilders.terms("product_group_by_price").field("price")
                        .subAggregation(AggregationBuilders.dateHistogram("product_group_by_created_date_time").field("created_date_time")
                                .dateHistogramInterval(DateHistogramInterval.YEAR)
                                .subAggregation(AggregationBuilders.avg("product_avg_price").field("price")))
                ).execute().actionGet();

        Map<String, Aggregation> aggregationMap = searchResponse.getAggregations().asMap();

        StringTerms productGroupByPrice = (StringTerms) aggregationMap.get("product_group_by_price");
        Iterator<StringTerms.Bucket> productGroupByPriceIterator = productGroupByPrice.getBuckets().iterator();
        while (productGroupByPriceIterator.hasNext()) {
            Terms.Bucket productGroupByPriceBucket = productGroupByPriceIterator.next();
            logger.info("--------------------------------F" + productGroupByPriceBucket.getKey() + ":" + productGroupByPriceBucket.getDocCount());

            Histogram productGroupByPrice1 = (Histogram) productGroupByPriceBucket.getAggregations().asMap().get("product_group_by_price");
            Iterator<org.elasticsearch.search.aggregations.bucket.histogram.Histogram.Bucket> groupByCreateDateTimeIterator = (Iterator<Histogram.Bucket>) productGroupByPrice1.getBuckets().iterator();
            while (groupByCreateDateTimeIterator.hasNext()) {
                Histogram.Bucket groupByCreateDateTimeBucket = groupByCreateDateTimeIterator.next();
                logger.info("--------------------------------F" + groupByCreateDateTimeBucket.getKey() + ":" + groupByCreateDateTimeBucket.getDocCount());

                Avg avgPrice = (Avg) groupByCreateDateTimeBucket.getAggregations().asMap().get("product_avg_price");
                logger.info("--------------------------------F" + avgPrice.getValue());
            }
        }


    }


}