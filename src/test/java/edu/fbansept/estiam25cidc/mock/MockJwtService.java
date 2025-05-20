package edu.fbansept.estiam25cidc.mock;

import edu.fbansept.estiam25cidc.service.IJwtService;

public class MockJwtService implements IJwtService {
    @Override
    public String generateToken(String email) {
        return "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhQGEuY29tIn0.9t1ocuqEU3o2ROATDyK_jSBn6AxOORn7cyZxJVxoQ60";
    }
}
