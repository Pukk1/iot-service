package com.iver.ruleengine.service.impl;

import com.google.gson.JsonElement;
import com.iver.ruleengine.model.DevicePackage;
import com.iver.ruleengine.model.RuleCheck;
import com.iver.ruleengine.repository.RuleChecksRepository;
import com.iver.ruleengine.rules.Rule;
import com.iver.ruleengine.service.Logger;
import com.iver.ruleengine.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RuleServiceImpl implements RuleService {

    private final Map<String, Rule> rules;
    private final RuleChecksRepository ruleChecksRepository;
    private final Logger logger;

    @Autowired
    public RuleServiceImpl(
            RuleChecksRepository ruleChecksRepository,
            Logger logger,
            Map<String, Rule> rules
    ) {
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
            logger.log(k + " " + result);
        });
    }
}
