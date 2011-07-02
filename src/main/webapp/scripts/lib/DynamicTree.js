var DynamicTree = Class.create({
	
	initialize: function(element) {
		this.element = $(element);
		this.boundClickHandler = this.clickHandler.bind(this);
		this.element.observe('click', this.boundClickHandler);
	},
	
	destroy: function() {
		if (this.element) {
			this.element.stopObserving('click', this.boundClickHandler);
			this.element = undefined;
		}
	},
	
	clickHandler: function(event) {
		var target = event.element();
		if (target.match('.node em')) {
			this.addChildrenIfChildless(target);
		} else if (target.match('.node')) {
			this.toggleTree(target);
		}
	},
	
	addChildrenIfChildless: function(em) {
		var children = em.up('.tree').down('.children');
		if (!children.down('.tree')) {
			this.addChildren(children);
		}
	},
	
	addChildren: function(children) {
		new Ajax.Request(window.location.href, {
			parameters: {
				action: 'getChildren'
			},
			onSuccess: function(transport) {
				children.innerHTML = transport.responseText;
			}
		});
	},
	
	toggleTree: function(toggleElement) {
		toggleElement.up('.tree').toggleClassName('collapsed');
	}
	
});
