package com.cybertek.services;

import com.cybertek.interfaces.ExtraSessions;


public class MockInterviewHours implements ExtraSessions {

    @Override
    public int getHours() {
        return 9;
    }
}
