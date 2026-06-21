package com.comphenix.protocol.events;

import org.bukkit.entity.Player;

/**
 * Stub for optional ProtocolLib dependency
 */
public class PacketEvent {
    public PacketContainer getPacket() {
        return null;
    }
    
    public Player getPlayer() {
        return null;
    }
    
    public void setCancelled(boolean cancelled) {
    }
    
    public void setPacket(PacketContainer packet) {
    }
}
