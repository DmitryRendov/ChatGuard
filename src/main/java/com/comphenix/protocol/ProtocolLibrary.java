package com.comphenix.protocol;

import org.bukkit.entity.Player;
import com.comphenix.protocol.events.PacketContainer;

/**
 * Stub for optional ProtocolLib dependency
 * This is only used if ProtocolLib is not available
 */
public class ProtocolLibrary {
    private static final ProtocolManager MANAGER = new ProtocolManager();
    
    public static ProtocolManager getProtocolManager() {
        return MANAGER;
    }
    
    public static class ProtocolManager {
        public void addPacketListener(Object listener) {
        }
        
        public void removePacketListener(Object listener) {
        }
        
        public void sendServerPacket(Player player, PacketContainer packet) {
        }
    }
}
