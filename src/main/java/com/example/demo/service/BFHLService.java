package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BFHLRequest;
import com.example.demo.exception.BadRequestException;

@Service
public class BFHLService {

    public Object process(BFHLRequest req) {

        int count = 0;
        if (req.getFibonacci() != null) count++;
        if (req.getPrime() != null) count++;
        if (req.getLcm() != null) count++;
        if (req.getHcf() != null) count++;
        if (req.getAI() != null) count++;

        if (count != 1)
            throw new BadRequestException("Exactly one input required");

        if (req.getFibonacci() != null)
            return fibonacci(req.getFibonacci());

        if (req.getPrime() != null)
            return primes(req.getPrime());

        if (req.getLcm() != null)
            return lcm(req.getLcm());

        if (req.getHcf() != null)
            return hcf(req.getHcf());

        return askAI(req.getAI());
    }

    /* ---------------- Fibonacci ---------------- */

    private List<Integer> fibonacci(int n) {

        if (n <= 0 || n > 1000)
            throw new BadRequestException("Invalid fibonacci input");

        List<Integer> list = new ArrayList<>();

        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            list.add(a);
            int temp = a + b;
            a = b;
            b = temp;
        }

        return list;
    }

    /* ---------------- Prime Filter ---------------- */

    private List<Integer> primes(List<Integer> nums) {

        if (nums == null || nums.isEmpty())
            throw new BadRequestException("Prime array cannot be empty");

        List<Integer> result = new ArrayList<>();

        for (Integer num : nums) {
            if (num != null && isPrime(num)) {
                result.add(num);
            }
        }

        return result;
    }

    private boolean isPrime(int n) {

        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; (long) i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    /* ---------------- HCF ---------------- */

    private long hcf(List<Integer> nums) {

        if (nums == null || nums.isEmpty())
            throw new BadRequestException("HCF array cannot be empty");

        long result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result = gcd(result, nums.get(i));
        }

        return result;
    }

    /* ---------------- LCM ---------------- */

    private long lcm(List<Integer> nums) {

        if (nums == null || nums.isEmpty())
            throw new BadRequestException("LCM array cannot be empty");

        long result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            long val = nums.get(i);
            result = (result / gcd(result, val)) * val;
        }

        return result;
    }

    /* ---------------- GCD ---------------- */

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return Math.abs(a);
    }

    /* ---------------- AI Stub ---------------- */

    private String askAI(String question) {

        String response = "Mumbai"; // Replace with actual AI API

        return response.split("\\s+")[0];
    }
}