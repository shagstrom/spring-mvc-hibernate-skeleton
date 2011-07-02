var simulateEvent = function(element, eventName, options) {
	var bubble = true;
	var cancelable = true;
	var event;
	if (document.createEvent) {
		event = document.createEvent("UIEvents");
		event.initUIEvent(eventName, bubble, cancelable, window, 1);
		Object.extend(event, options || {});
		element.dispatchEvent(event);
	} else if (document.createEventObject) {
		event = document.createEventObject();
		Object.extend(event, options || {});
		element.fireEvent("on" + eventName, event);
		event.cancelBubble = cancelable;
	} else {
		throw new Error("Firing event failed");
	}
};
