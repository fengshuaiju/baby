package com.feng.util.elastic;

import java.io.IOException;

import org.elasticsearch.common.settings.Settings;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.indices.CreateIndex;

public class ElasticSerch {
	
	public static void main(String[] args) throws IOException{
		
		JestClientFactory factory = new JestClientFactory();
		 factory.setHttpClientConfig(new HttpClientConfig
		                        .Builder("http://localhost:9200")
		                        .multiThreaded(true)
		                        .build());
		 JestClient client = factory.getObject();
		
		
		 //client.execute(new CreateIndex.Builder("articles").build());
		 
		 String settings = "\"settings\" : {\n" +
	                "        \"number_of_shards\" : 5,\n" +
	                "        \"number_of_replicas\" : 1\n" +
	                "    }\n";

		 client.execute(new CreateIndex.Builder("articles").settings(Settings.builder().loadFromSource(settings).build().getAsMap()).build());
		
	}
	
	

}
