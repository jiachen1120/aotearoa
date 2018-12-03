package com.christoff.aotearoa.intern.gateway.metadata;

import com.christoff.aotearoa.intern.gateway.transform.ITransform;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VariableMetadata
{
    private String _varName;
    private Map<String,List<String>> _varPropertiesMap;
    private List<String> _values;
    private ITransform _transform;
    
    public VariableMetadata(
        String varName,
        List<Object> values,
        Map<String,List<String>> varPropertiesMap,
        ITransform tx)
    {
        _varName = varName;
        _values = toStringList(values);
        _varPropertiesMap = varPropertiesMap;
        _transform = tx;
    }

    private static List<String> toStringList(List<Object> objValues) {
        List<String> values = new LinkedList<>();
        for(Object val : values)
            values.add(val.toString());
        return values;
    }

    public String getName() {
        return _varName;
    }
    
    public List<String> getProperty(String key) {
        return _varPropertiesMap.get(key);
    }
    
    public ITransform transform() {
        return _transform;
    }
    
    public String getVariableString() {
        return _values.get(0);
    }
    
    public List<String> getVariableListString() {
        return _values;
    }
    
    public String getTransformedVariableString() {
        return _transform.transform(_values);
    }
    
    public int getVariableInteger() {
        return Integer.parseInt(_values.get(0));
    }
}
