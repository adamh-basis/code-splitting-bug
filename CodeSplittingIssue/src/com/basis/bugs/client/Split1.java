package com.basis.bugs.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;

/**
 * @author ahawtho
 *
 */
public class Split1 {
    private static final int MSGS = 12;

    private Dispatcher m_group1;
    private Dispatcher m_group2;
    private Dispatcher m_group3;

    public void run() {
        Scheduler.get().scheduleDeferred(new Cmd());
    }

    void dispatch(final MsgData p_data) {
        int tag = p_data.tag();
        if (tag < 4) {
            if (m_group1 == null) {
                m_group1 = new Dispatcher1();
                m_group1.dispatch(p_data);
            } else {
                m_group1.dispatch(p_data);
            }
        } else if (tag < 8) {
            if (m_group2 == null) {
                GWT.runAsync(Dispatcher2.class, new RunAsyncCallback() {
                    @Override
                    public void onSuccess() {
                        m_group2 = new Dispatcher2();
                        m_group2.dispatch(p_data);
                    }

                    @Override
                    public void onFailure(Throwable p_reason) {
                        p_reason.printStackTrace();
                    }
                });
            } else {
                m_group2.dispatch(p_data);
            }
        } else if (tag < 12) {
            if (m_group3 == null) {
                GWT.runAsync(Dispatcher3.class, new RunAsyncCallback() {
                    @Override
                    public void onSuccess() {
                        m_group3 = new Dispatcher3();
                        m_group3.dispatch(p_data);
                    }

                    @Override
                    public void onFailure(Throwable p_reason) {
                        p_reason.printStackTrace();
                    }
                });
            } else {
                m_group3.dispatch(p_data);
            }
        }
    }

    private final class Cmd implements ScheduledCommand {
        private int m_value = 0;

        public Cmd() {
        }

        @Override
        public void execute() {
            dispatch(new MsgData(m_value));
            m_value++;
            if (m_value < MSGS)
                Scheduler.get().scheduleDeferred(this);
        }
    }
}
