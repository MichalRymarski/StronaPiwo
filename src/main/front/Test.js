function fetchData() {
    fetch('http://localhost:8081/api/your-endpoint')
        .then(response => response.json())
        .then(data => {
            var ul = document.getElementById('itemList');
            ul.innerHTML = ''; // clear the list before adding new items
            data.forEach(item => {
                var li = document.createElement('li');
                li.appendChild(document.createTextNode(item)); // replace 'item' with the actual property you want to display
                var deleteBtn = document.createElement('button');
                deleteBtn.appendChild(document.createTextNode('Delete'));
                deleteBtn.setAttribute('onclick', 'deleteItem(this)');
                li.appendChild(deleteBtn);
                ul.appendChild(li);
            });
        })
        .catch(error => console.error('Error:', error));
}

function insertData(data) {
    fetch('http://localhost:8081/api/your-endpoint', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
        .then(response => response.text())
        .then(text => console.log(text))
        .catch(error => console.error('Error:', error));
}