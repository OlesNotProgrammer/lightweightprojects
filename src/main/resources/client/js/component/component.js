class Component {
    static #wrapper = document.querySelector("body>#wrapper");
    static #activeComponent;

    #buildFunction;
    #handleFunction;
    #destroyFunction;
    #body;

    constructor(buildFunction, handleFunction, destroyFunction) {
        this.#buildFunction = buildFunction;
        this.#handleFunction = handleFunction;
        this.#destroyFunction = destroyFunction;
    }

    build() {
        if (this == Component.#activeComponent) {
            return;
        } else if (Component.#activeComponent) {  
            Component.#activeComponent.#destroy();
        }

        this.#body = this.#buildFunction();
        Component.#wrapper.append(this.#body);

        this.#handleFunction()

        Component.#activeComponent = this;
    }

    #destroy() {
        if (this == Component.#activeComponent) {
            this.#destroyFunction();
            this.#body.remove();
            Component.#activeComponent = undefined;
        }
    }
}

const createBlock = (tag = "div", ...attributeList) => {
    elem = document.createElement(tag);

    if (attributeList) {
        attributeList.forEach(attribute => elem.setAttribute(...attribute));
    }

    return elem;
};

const createElement = (tag, text, ...attributeList) => {
    elem = createBlock(tag, ...attributeList);
    elem.innerHTML = text;

    return elem;
};

const createStructure = (parent, ...childe) => {
    parent.append(...childe);
    return parent;
};

const select = selector => {
    return document.querySelector(selector);
};
