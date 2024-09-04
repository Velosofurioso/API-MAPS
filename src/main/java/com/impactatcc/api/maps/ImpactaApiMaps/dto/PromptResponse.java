package com.impactatcc.api.maps.ImpactaApiMaps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromptResponse implements Serializable {

    private String response;
}
