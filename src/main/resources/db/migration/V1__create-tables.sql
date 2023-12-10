CREATE TABLE agendamento
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    data           datetime              NOT NULL,
    pet_id         BIGINT                NOT NULL,
    servico_id     BIGINT                NOT NULL,
    funcionario_id BIGINT                NOT NULL,
    local_id       BIGINT                NOT NULL,
    observacao     VARCHAR(255)          NULL,
    CONSTRAINT pk_agendamento PRIMARY KEY (id)
);

CREATE TABLE cliente
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    nome     VARCHAR(64)           NOT NULL,
    contato  VARCHAR(128)          NOT NULL,
    endereco VARCHAR(128)          NOT NULL,
    CONSTRAINT pk_cliente PRIMARY KEY (id)
);

CREATE TABLE cliente_pets
(
    cliente_id BIGINT NOT NULL,
    pets_id    BIGINT NOT NULL
);

CREATE TABLE funcionario
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    nome          VARCHAR(64)           NOT NULL,
    contato       VARCHAR(128)          NOT NULL,
    endereco      VARCHAR(128)          NOT NULL,
    especialidade VARCHAR(64)           NOT NULL,
    status        BIT(1)                NOT NULL,
    CONSTRAINT pk_funcionario PRIMARY KEY (id)
);

CREATE TABLE local
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    nome       VARCHAR(64)           NOT NULL,
    descricao  VARCHAR(64)           NOT NULL,
    capacidade INT                   NOT NULL,
    endereco   VARCHAR(128)          NULL,
    CONSTRAINT pk_local PRIMARY KEY (id)
);

CREATE TABLE pet
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    nome        VARCHAR(64)           NOT NULL,
    especie     VARCHAR(32)           NOT NULL,
    raca        VARCHAR(32)           NOT NULL,
    tipo_pelo   VARCHAR(32)           NOT NULL,
    cor         VARCHAR(32)           NOT NULL,
    peso_gramas BIGINT                NOT NULL,
    tamanho_cm  BIGINT                NOT NULL,
    nascimento  date                  NOT NULL,
    observacao  VARCHAR(255)          NULL,
    CONSTRAINT pk_pet PRIMARY KEY (id)
);

CREATE TABLE servico
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    nome           VARCHAR(64)           NOT NULL,
    descricao      VARCHAR(255)          NOT NULL,
    valor_centavos BIGINT                NOT NULL,
    tempo_segundos INT                   NOT NULL,
    CONSTRAINT pk_servico PRIMARY KEY (id)
);

ALTER TABLE cliente_pets
    ADD CONSTRAINT uc_cliente_pets_pets UNIQUE (pets_id);

ALTER TABLE agendamento
    ADD CONSTRAINT FK_AGENDAMENTO_ON_FUNCIONARIO FOREIGN KEY (funcionario_id) REFERENCES funcionario (id);

ALTER TABLE agendamento
    ADD CONSTRAINT FK_AGENDAMENTO_ON_LOCAL FOREIGN KEY (local_id) REFERENCES local (id);

ALTER TABLE agendamento
    ADD CONSTRAINT FK_AGENDAMENTO_ON_PET FOREIGN KEY (pet_id) REFERENCES pet (id);

ALTER TABLE agendamento
    ADD CONSTRAINT FK_AGENDAMENTO_ON_SERVICO FOREIGN KEY (servico_id) REFERENCES servico (id);

ALTER TABLE cliente_pets
    ADD CONSTRAINT fk_clipet_on_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id);

ALTER TABLE cliente_pets
    ADD CONSTRAINT fk_clipet_on_pet FOREIGN KEY (pets_id) REFERENCES pet (id);