CREATE TABLE agendamento
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    data           datetime              NULL,
    pet_id         BIGINT                NULL,
    servico_id     BIGINT                NULL,
    funcionario_id BIGINT                NULL,
    local_id       BIGINT                NULL,
    observacao     VARCHAR(255)          NULL,
    CONSTRAINT pk_agendamento PRIMARY KEY (id)
);

CREATE TABLE cliente
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    nome     VARCHAR(255)          NULL,
    contato  VARCHAR(255)          NULL,
    endereco VARCHAR(255)          NULL,
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
    nome          VARCHAR(255)          NULL,
    contato       VARCHAR(255)          NULL,
    endereco      VARCHAR(255)          NULL,
    especialidade VARCHAR(255)          NULL,
    status        BIT(1)                NULL,
    CONSTRAINT pk_funcionario PRIMARY KEY (id)
);

CREATE TABLE local
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    nome       VARCHAR(255)          NULL,
    descricao  VARCHAR(255)          NULL,
    capacidade INT                   NULL,
    endereco   VARCHAR(255)          NULL,
    CONSTRAINT pk_local PRIMARY KEY (id)
);

CREATE TABLE pet
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    nome        VARCHAR(255)          NULL,
    especie     VARCHAR(255)          NULL,
    raca        VARCHAR(255)          NULL,
    tipo_pelo   VARCHAR(255)          NULL,
    cor         VARCHAR(255)          NULL,
    peso_gramas BIGINT                NULL,
    tamanho_cm  BIGINT                NULL,
    nacimento   date                  NULL,
    observacao  VARCHAR(255)          NULL,
    CONSTRAINT pk_pet PRIMARY KEY (id)
);

CREATE TABLE servico
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    nome           VARCHAR(255)          NULL,
    descricao      VARCHAR(255)          NULL,
    valor_centavos BIGINT                NULL,
    tempo_segundos INT                   NULL,
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