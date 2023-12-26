package com.pattern.design.behavioralDesignPatterns.mediator.components;

import com.pattern.design.behavioralDesignPatterns.mediator.mediator.Mediator;

/**
 * 컴포넌트들은 다른 컴포넌트를 인식하지 못해야 함
 * - 컴포넌트 내에서 또는 컴포넌트에 중요한 일이 발생하면, 컴포넌트는 이를 중재자에게만 전달
 * - 중재자는 알림을 받으면 발송자를 쉽게 식별 가능하고, 이는 응답으로 어떤 컴포넌트가 작동되어야 하는지 결정하기에 충분
 *
 * 컴포넌트의 관점에서는 모든 것들이 블랙박스들(기능은 알지만, 작동 원리를 알 수 없는 복잡한 기계나 시스템)처럼 보임
 * - 발송자는 누가 요청을 처리할지 모르고, 수신자는 누가 처음에 요청을 보냈는지를 모름
 */
public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}