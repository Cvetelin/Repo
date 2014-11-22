var myrules = {
    // resizable text area
    'TEXTAREA' : function(textarea) {
    	var handle = document.createElement('div');
    	handle.className = 'textarea-handle';
        textarea.parentNode.insertBefore(handle, textarea.nextSibling);

        var Event = YAHOO.util.Event;

        handle.onmousedown = function(ev) {
            ev = Event.getEvent(ev);
            var offset = textarea.offsetHeight-Event.getPageY(ev);
            textarea.style.opacity = 0.5;
            document.onmousemove = function(ev) {
                ev = Event.getEvent(ev);
                function max(a,b) { if(a<b) return b; else return a; }
                textarea.style.height = max(32, offset + Event.getPageY(ev)) + 'px';
                return false;
            };
            document.onmouseup = function() {
                document.onmousemove = null;
                document.onmouseup = null;
                textarea.style.opacity = 1;
            }
        };
        handle.ondblclick = function() {
            textarea.style.height = "";
            textarea.rows = textarea.value.split("\n").length;
        }
    },
    'PRE.java' : function(element) {		
		// hide the original element
		element.style.display = 'none';
		
		// instantiate a brush
		var highlighter = new dp.sh.Brushes.Java();
		
		highlighter.noGutter = false;
		highlighter.addControls = false;
		highlighter.collapse = false;
		highlighter.tabsToSpaces = true;
		highlighter.Highlight(element['innerHTML']);
		highlighter.source = element;

		element.parentNode.insertBefore(highlighter.div, element);
    }
};

Behaviour.register(myrules);

