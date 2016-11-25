package com.rain.learn.sms.view.tags;

import static com.rain.learn.sms.view.tags.Validate.MESSAGE;
import static com.rain.learn.sms.view.tags.Validate.RULE;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.RequestContext;

import com.rain.learn.sms.util.CollectionUtil;
import com.rain.learn.sms.util.StringUtil;

public abstract class TagUtil {

    private static Logger logger = LoggerFactory.getLogger(TagUtil.class);

    public static Map<Validate, String> genTagRuleAndMessage(Field field, RequestContext context) {
        if (field == null) {
            return Collections.<Validate, String> emptyMap();
        }
        boolean hasAnnotation = false;
        String fieldName = field.getName();
        StringBuilder rule = new StringBuilder(fieldName).append(":{");
        StringBuilder message = new StringBuilder(fieldName).append(":{");
        String text;
        NotEmpty notEmpty = field.getAnnotation(NotEmpty.class);
        if (notEmpty != null) {
            rule.append("required:true");
            text = notEmpty.message();
            logger.debug("not empty message: {}", text);
            message.append(context.getMessage(text.substring(1, text.length() - 1)));
            hasAnnotation = true;
        }
        Length length = field.getAnnotation(Length.class);
        if (length != null) {
            if (hasAnnotation) {
                rule.append(",");
                message.append(",");
            }
            rule.append("rangelength:[").append(length.min()).append(",").append(length.max()).append("]");
            text = length.message();
            logger.debug("length message: {}", text);
            message.append(context.getMessage(text.substring(1, text.length() - 1)));
            hasAnnotation = true;
        }
        Email email = field.getAnnotation(Email.class);
        if (email != null) {
            if (hasAnnotation) {
                rule.append(",");
                message.append(",");
            }
            rule.append("email:true");
            text = email.message();
            logger.debug("email message: {}", text);
            message.append(context.getMessage(text.substring(1, text.length() - 1)));
            hasAnnotation = true;
        }
        rule.append("}");
        message.append("}");
        if (!hasAnnotation) {
            return Collections.<Validate, String> emptyMap();
        }
        Map<Validate, String> map = new HashMap<>();
        map.put(RULE, rule.toString());
        map.put(MESSAGE, message.toString());
        return map;
    }

    public static Map<Validate, String> genTagRulesAndMessages(Field[] fields, String rAppend, String mAppend,
            RequestContext context) {
        if (CollectionUtil.isEmpty(fields)) {
            return Collections.<Validate, String> emptyMap();
        }
        StringBuilder rules = new StringBuilder("rules:{");
        StringBuilder messages = new StringBuilder("messages:{");
        boolean hasRule = false;
        Map<Validate, String> temp;
        for (Field field : fields) {
            temp = genTagRuleAndMessage(field, context);
            if (!temp.isEmpty()) {
                if (hasRule) {
                    rules.append(",");
                    messages.append(",");
                }
                rules.append(temp.get(RULE));
                messages.append(temp.get(MESSAGE));
                hasRule = true;
            }
        }
        if (StringUtil.notEmpty(rAppend, mAppend)) {
            if (hasRule) {
                rules.append(",");
                messages.append(",");
            }
            rules.append(rAppend);
            messages.append(mAppend);
            hasRule = true;
        }

        rules.append("}");
        messages.append("}");
        if (!hasRule) {
            return Collections.<Validate, String> emptyMap();
        }
        Map<Validate, String> map = new HashMap<>();
        map.put(RULE, rules.toString());
        map.put(MESSAGE, messages.toString());
        return map;
    }

    public static Map<Validate, String> genTagRulesAndMessages(Object model, String rAppend, String mAppend,
            RequestContext context) {
        if (model == null) {
            return Collections.<Validate, String> emptyMap();
        }
        return genTagRulesAndMessages(model.getClass().getDeclaredFields(), rAppend, mAppend, context);
    }
}
