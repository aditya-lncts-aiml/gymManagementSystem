 function checkSelection() {
        var items = document.getElementsByName('selectItem');
        var submitButton = document.getElementById('submit-button');
        var selected = false;
        
        for (var i = 0; i < items.length; i++) {
            if (items[i].checked) {
                selected = true;
                break;
            }
        }

        submitButton.disabled = !selected;
    }

    window.onload = function() {
        checkSelection();
        var items = document.getElementsByName('selectItem');
        for (var i = 0; i < items.length; i++) {
            items[i].addEventListener('change', checkSelection);
        }
    }