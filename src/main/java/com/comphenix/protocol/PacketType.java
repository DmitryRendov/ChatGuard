package com.comphenix.protocol;

/**
 * Stub for optional ProtocolLib dependency
 */
public class PacketType {
    public static class Play {
        public static class Client {
            public static final PacketType CHAT = new PacketType();
        }
        public static class Server {
            public static final PacketType CHAT = new PacketType();
        }
    }
}
