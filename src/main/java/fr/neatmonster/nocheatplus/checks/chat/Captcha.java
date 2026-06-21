package fr.neatmonster.nocheatplus.checks.chat;

/**
 * Stub for optional NoCheatPlus dependency
 */
public class Captcha {
    public Captcha() {
    }
    
    public boolean shouldCheckCaptcha(ChatConfig config, ChatData data) {
        return false;
    }
}
