package models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class BasketAddRequestModel {

    String userId;
    List<BusketAddRequestCollectionModel> collectionOfIsbns;
}
