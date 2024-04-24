package com.example.springplayground.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

public class demo14 {

    @Data
    @NoArgsConstructor
    static class Sample {
        String name;
        String serviceCode;
        Integer key;
    }

    public static void extract(String str) {
        String[] split = str.substring(1, str.length() - 1).split(",");
        Sample sample = new Sample();
        Arrays.stream(split).forEach(s -> {
            String[] split1 = s.trim().split(":");
            if ("name".equals(split1[0].trim().substring(1, split1[0].length() - 1))) {
                sample.setName(split1[1].trim().substring(1, split1[1].length() - 2));
            }
            else if ("serviceCode".equals(split1[0].trim().substring(1, split1[0].length() - 1))) {
                sample.setServiceCode(split1[1].trim().substring(1, split1[1].length() - 2));
            }
            else if ("key".equals(split1[0].trim().substring(1, split1[0].length() - 1))) {
                sample.setKey(Integer.parseInt(split1[1].trim().substring(0, split1[1].length() - 1)));
            }
        });
        System.out.println(sample);
    }

    public static void main(String[] args) {
        String str1 = "{'name': 'me', 'serviceCode': 'abc', 'key': 123}";
        extract(str1);
    }
}
