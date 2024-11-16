package models;

import lombok.Data;

import java.util.List;

@Data
public class BasketAddRequestModel {

    String userId;
    List<BusketAddRequestCollectionModel> collectionOfIsbns;
}
