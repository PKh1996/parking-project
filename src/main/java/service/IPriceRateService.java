package service;

import com.kurdestan.Vehicleparking.model.PriceRate;
import java.util.List;

public interface IPriceRateService {




    PriceRate save (PriceRate  priceRate);
    void delete (Long id);
    PriceRate getById(Long id);
    List<PriceRate> getAll();
    List<PriceRate> getAllByParking(Long parkId); // تمامی PriceRate هارو براساس parking ها به من برگردان.



}
