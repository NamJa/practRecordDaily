package com.example.ddori.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {

    //싱글톤 클래스에선 get()과 private 생성자를 생성해야한다.
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    public static CrimeLab get(Context context) {
        if(sCrimeLab == null)
        {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        {
            Crime crime = new Crime();
            crime.setTitle("범죄 #" + i);
            crime.setSolved(i % 2 == 0); //짝수 번째 요소엔 true 설정
            mCrimes.add(crime);
        }
    }

    public List<Crime> getmCrimes()
    {
        return mCrimes;
    }

    public Crime getCrime(UUID id)
    {
        for(Crime crime : mCrimes) {
            if(crime.getmId().equals(id)){
                return crime;
            }
        }
        return null;
    }
}

