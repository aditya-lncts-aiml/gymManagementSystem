function checkSelection() {
    var items = document.getElementsByName('selectItem');
    var submitButton = document.getElementById('submit-button');
    var userSelect = document.getElementsByName('userId')[0];
    var selected = false;
    var userSelected = userSelect.value !== "";

    for (var i = 0; i < items.length; i++) {
        if (items[i].checked) {
            selected = true;
            break;
        }
    }

    submitButton.disabled = !(selected && userSelected);
}

window.onload = function() {
    checkSelection();
    var items = document.getElementsByName('selectItem');
    for (var i = 0; i < items.length; i++) {
        items[i].addEventListener('change', checkSelection);
    }

    var userSelect = document.getElementsByName('userId')[0];
    userSelect.addEventListener('input', checkSelection);
}