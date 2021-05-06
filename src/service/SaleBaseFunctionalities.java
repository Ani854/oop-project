package service;

import model.BaseDocument;

import java.text.ParseException;

public interface SaleBaseFunctionalities {
    public BaseDocument create() throws ParseException;

    public void validate(BaseDocument document) throws Exception;

    public String store(BaseDocument document) throws Exception;

}
