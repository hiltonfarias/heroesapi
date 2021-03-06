package com.hiltonfarias.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import static com.hiltonfarias.heroesapi.constant.HeroesConstant.ENDPOINT_DYNAMO;
import static com.hiltonfarias.heroesapi.constant.HeroesConstant.REGION_DYNAMO;


public class HeroesData {
    public static void main(String[] args) throws Exception {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                        ENDPOINT_DYNAMO,
                        REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Table_Demo");
        Item hero1 = new Item()
                .withPrimaryKey("id", 1)
                .withString("name", "Mulher maravilha")
                .withString("universe", "dc comics")
                .withNumber("films", 3);

        Item hero2 = new Item()
                .withPrimaryKey("id", 2)
                .withString("name", "Viuva negra")
                .withString("universe", "marvel")
                .withNumber("films", 2);

        Item hero3 = new Item()
                .withPrimaryKey("id", 3)
                .withString("name", "Capita marvel")
                .withString("universe", "marvel")
                .withNumber("films", 3);

        PutItemOutcome putItemOutcome1 = table.putItem(hero1);
        PutItemOutcome putItemOutcome2 = table.putItem(hero2);
        PutItemOutcome putItemOutcome3 = table.putItem(hero3);

    }
}
