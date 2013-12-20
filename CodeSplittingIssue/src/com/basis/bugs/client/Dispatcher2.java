package com.basis.bugs.client;

import com.google.gwt.core.client.GWT;

/**
 * @author ahawtho
 *
 */
public class Dispatcher2 implements Dispatcher {

    public Dispatcher2() {
    }

    @Override
    public void dispatch(MsgData p_data) {
        int tag = p_data.tag();
        Runnable r;
        switch (tag % 4) {
            case 0:
                r = new Class0(tag);
                break;
            case 1:
                r = new Class1(tag);
                break;
            case 2:
                r = new Class2(tag);
                break;
            case 3:
                r = new Class3(tag);
                break;
            default:
                GWT.log("Unexpected tag value: " + tag);
                r = null;
                break;
        }
        if (r != null)
            r.run();
    }

    public static class Class0 implements Runnable {
        private final int m_tag;

        public Class0(int p_tag) {
            m_tag = p_tag;
        }

        @Override
        public void run()  {
            GWT.log(getClass().getName() + ": " + m_tag);
        }
    }

    public static class Class1 implements Runnable {
        private final int m_tag;

        public Class1(int p_tag) {
            m_tag = p_tag;
        }

        @Override
        public void run()  {
            GWT.log(getClass().getName() + ": " + m_tag);
        }
    }

    public static class Class2 implements Runnable {
        private final int m_tag;

        public Class2(int p_tag) {
            m_tag = p_tag;
        }

        @Override
        public void run()  {
            GWT.log(getClass().getName() + ": " + m_tag);
        }
    }

    public static class Class3 implements Runnable {
        private final int m_tag;

        public Class3(int p_tag) {
            m_tag = p_tag;
        }

        @Override
        public void run()  {
            GWT.log(getClass().getName() + ": " + m_tag);
        }
    }
}
