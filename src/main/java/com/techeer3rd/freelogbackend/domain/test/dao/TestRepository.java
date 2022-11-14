package com.techeer3rd.freelogbackend.domain.test.dao;

import com.techeer3rd.freelogbackend.domain.test.domain.TestData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TestRepository extends JpaRepository<TestData, UUID> {
    // 각종 메소드는 Java Reflection에 의해서 Runtime 때 주입됨.(?)
}
