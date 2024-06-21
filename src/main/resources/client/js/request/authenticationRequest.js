const authenticationPath = `http://${document.location.host}/authentication`;

const register = account => {
    fetch(`${authenticationPath}/register`,
        {
            method: "POST",
            body: JSON.stringify(account)
        })
    .then(response => response.json())
    .then(json => activateToken(json));
};

const authenticate = accountDetail => {
    fetch(`${authenticationPath}/authenticate`,
        {
            method: "POST",
            body: JSON.stringify(accountDetail)
        })
    .then(response => response.json())
    .then(json => activateToken(json));
};

const activateToken = json => {
    authenticatonToken = json.token;
    ApplicationComponent.build();
};

const validateToken = () => {
    fetch(`${authenticationPath}/validateToken`,
        {
            method: "GET",
            headers: {
                "AuthenticationToken": `Bearer ${authenticatonToken}`
            }
        })
    .then(response => response.json())
    .then(json => {
        if (json.status) {
            ApplicationComponent.build();
        } else {
            RegistrationComponent.build();
        }
    });
};
