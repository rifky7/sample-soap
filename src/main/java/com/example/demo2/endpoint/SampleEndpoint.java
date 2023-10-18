package com.example.demo2.endpoint;

import com.example.demo2.dto.RequestDTO;
import com.example.demo2.dto.ResponseDTO;
import com.example.demo2.model.Sampleservicerq;
import com.example.demo2.model.Sampleservicers;
import com.example.demo2.service.SampleServiceBackendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SampleEndpoint {
    @Autowired
    private SampleServiceBackendService service;

    @PayloadRoot(namespace = "http://www.oracle.com/external/services/sampleservice/request/v1.0",
            localPart = "sampleservicerq")
    @ResponsePayload
    public Sampleservicers testoResponse(@RequestPayload Sampleservicerq sampleservicerq) {

        RequestDTO.SampleServiceRq requestData = RequestDTO.SampleServiceRq.builder()
                .serviceId(sampleservicerq.getServiceId())
                .orderType(sampleservicerq.getOrderType())
                .type(sampleservicerq.getType())
                .trxId(sampleservicerq.getTrxId())
                .build();

        ResponseDTO responseDTO = service.getSampleData(RequestDTO.builder().sampleServicerq(requestData).build());

        Sampleservicers sampleservicers = new Sampleservicers();
        sampleservicers.setErrorCode(responseDTO.getSampleServicers().getErrorCode());
        sampleservicers.setErrorMsg(responseDTO.getSampleServicers().getErrorMsg());
        sampleservicers.setTrxId(responseDTO.getSampleServicers().getTrxId());
        return sampleservicers;
    }

}
