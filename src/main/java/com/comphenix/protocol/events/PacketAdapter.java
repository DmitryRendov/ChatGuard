package com.comphenix.protocol.events;

import org.bukkit.plugin.Plugin;

/**
 * Stub for optional ProtocolLib dependency
 */
public abstract class PacketAdapter {
    public PacketAdapter(Plugin plugin, Object... packets) {
    }
    
    public void onPacketReceiving(PacketEvent event) {
    }
    
    public void onPacketSending(PacketEvent event) {
    }
}
