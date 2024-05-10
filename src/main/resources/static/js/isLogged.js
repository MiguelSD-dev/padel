fetch(location.origin + "/isLogged")
    .then(response => response.json())
    .then(data => {
        if(data === false){
            window.location.href = "/login"
        }
    })
