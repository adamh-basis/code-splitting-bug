package com.basis.bugs.client;

/**
 * @author ahawtho
 *
 */
public class MsgData {
    private final int m_tag;

    public MsgData(int p_tag) {
        m_tag = p_tag;
    }

    public int tag() {
        return m_tag;
    }
}
