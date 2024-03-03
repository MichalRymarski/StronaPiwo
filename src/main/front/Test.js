document.getElementById('myForm').addEventListener('submit', function(e) {
    e.preventDefault();

    var name = document.getElementById('name').value;
    var password = document.getElementById('password').value;

    fetch('http://localhost:8082/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({name: name, password: password}),
    })
        .then(response => response.text())
        .then(data => {
            document.getElementById('response').innerText = data;
        })
        .catch((error) => {
            console.error('Error:', error);
        });
});