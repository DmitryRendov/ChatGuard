package com.comphenix.protocol.events;

import com.comphenix.protocol.reflect.FieldAccessor;

/**
 * Stub for optional ProtocolLib dependency
 */
public class PacketContainer {
    private static final FieldAccessor ACCESSOR = new FieldAccessor();
    
    public PacketContainer(Object packetType) {
    }
    
    public FieldAccessor getStrings() {
        return ACCESSOR;
    }
    
    public FieldAccessor getBytes() {
        return ACCESSOR;
    }
    
    public FieldAccessor getChatComponents() {
        return ACCESSOR;
    }
}
