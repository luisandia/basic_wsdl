package com.bharath.ws.trainings;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2019-02-24T17:42:18.696-05:00
 * Generated source version: 3.0.2
 * 
 */
@WebService(targetNamespace = "http://trainings.ws.bharath.com/", name = "CustomerOrdersPortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CustomerOrdersPortType {

    @WebMethod
    @WebResult(name = "getOrdersResponse", targetNamespace = "http://trainings.ws.bharath.com/", partName = "parameters")
    public GetOrdersResponse getOrders(
        @WebParam(partName = "parameters", name = "getOrdersRequest", targetNamespace = "http://trainings.ws.bharath.com/")
        GetOrdersRequest parameters
    );

    @WebMethod
    @WebResult(name = "createOrdersResponse", targetNamespace = "http://trainings.ws.bharath.com/", partName = "parameters")
    public CreateOrdersResponse createOrders(
        @WebParam(partName = "parameters", name = "createOrdersRequest", targetNamespace = "http://trainings.ws.bharath.com/")
        CreateOrdersRequest parameters
    );
}
