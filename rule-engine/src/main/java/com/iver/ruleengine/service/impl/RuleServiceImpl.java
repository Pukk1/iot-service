package com.iver.ruleengine.service.impl;

import com.google.gson.JsonElement;
import com.iver.ruleengine.model.DevicePackage;
import com.iver.ruleengine.model.RuleCheck;
import com.iver.ruleengine.repository.RuleChecksRepository;
import com.iver.ruleengine.rules.Rule;
import com.iver.ruleengine.service.Logger;
import com.iver.ruleengine.service.RuleService;
import io.micrometer.common.util.StringUtils;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RuleServiceImpl implements RuleService {

    private final Map<String, Rule> rules;
    private final RuleChecksRepository ruleChecksRepository;
    private final Logger logger;
    private final MeterRegistry meterRegistry;

    @Autowired
    public RuleServiceImpl(RuleChecksRepository ruleChecksRepository, Logger logger, Map<String, Rule> rules,
            MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        this.ruleChecksRepository = ruleChecksRepository;
        this.logger = logger;
        this.rules = rules;
    }

    @Override
    public void checkAllRulesForMessage(DevicePackage devicePackage, Map<String, JsonElement> data) {
        rules.forEach((k, v) -> {
            boolean result = v.checkRule(devicePackage, data);
            RuleCheck ruleCheck = new RuleCheck(devicePackage.getDeviceId(), k, result);
            ruleChecksRepository.save(ruleCheck);
            if (ruleCheck.getResult()) {
                meterRegistry.counter("trust_result").increment();
            }
            logger.log(k + " " + result);
        });
    }
}
