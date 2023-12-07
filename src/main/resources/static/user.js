//User information-page
getUser()

function getUser() {
    fetch("api/user")
        .then(response => response.json())
        .then(user => {
            const userRole = user.authorities[0].name.toString().replace("ROLE_", "");
            const info = `$(
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.age}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${userRole}</td>
            </tr>)`;
            $('#userInfo').append(info)
        })
}