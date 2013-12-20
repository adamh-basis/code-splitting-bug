package com.basis.bugs.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;

/**
 * @author ahawtho
 *
 */
public class CodeSplittingEntry implements EntryPoint {
    @Override
    public void onModuleLoad() {
        // Simulate receiving messages on which to split:
        GWT.runAsync(Split1.class, new RunAsyncCallback() {
            @Override
            public void onSuccess() {
                new Split1().run();
            }

            @Override
            public void onFailure(Throwable p_reason) {
                p_reason.printStackTrace();
            }
        });
    }
}
