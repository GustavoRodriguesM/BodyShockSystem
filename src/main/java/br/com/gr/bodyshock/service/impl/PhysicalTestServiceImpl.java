package br.com.gr.bodyshock.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.gr.bodyshock.enums.Ativacao;
import br.com.gr.bodyshock.enums.Status;
import br.com.gr.bodyshock.exception.DietAndTrainingException;
import br.com.gr.bodyshock.model.Avaliacao;
import br.com.gr.bodyshock.model.Avaliado;
import br.com.gr.bodyshock.repository.PhysicalTestRepository;
import br.com.gr.bodyshock.service.PhysicalTestService;

@Service
public class PhysicalTestServiceImpl implements PhysicalTestService {

	@Autowired
	private PhysicalTestRepository physicalTestRepository;

	@Override
	public Long getSumPhysicalTests() {
		return this.physicalTestRepository.count();
	}

	@Override
	public Long getSumPhysicalTests(Calendar calendar, Status status) {
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
		return this.physicalTestRepository.countByDataAfterAndStatus(calendar, status);
	}

	@Override
	public Long getSumPhysicalTests(Status status) {
		return this.physicalTestRepository.countByStatus(status);
	}

	@Override
	public Double getPaymentsValue(Status status) {
		return (double) (getSumPhysicalTests(status) * 99);
	}

	@Override
	public List<Avaliacao> findByStatus(Status status) {
		return this.physicalTestRepository.findAllByStatus(status);
	}

	@Override
	public void validate(Avaliacao avaliacao) throws DietAndTrainingException {
		Avaliado avaliado = avaliacao.getAvaliado();
		if (avaliado.getDieta() != null && avaliado.getTreino() != null) {
			if (avaliacao.getStatus() == Status.PAGO) {
				avaliacao.setStatus(Status.PENDENTE);
				avaliacao.setDataPagamento(null);
			} else {
				avaliacao.setStatus(Status.PAGO);
				avaliacao.setDataPagamento(Calendar.getInstance());
			}
			this.physicalTestRepository.save(avaliacao);
		} else 
			throw new DietAndTrainingException();

	}

	@Override
	public List<Avaliacao> findByClient(Avaliado avaliado) {
		return this.physicalTestRepository.findByAvaliadoOrderByDataAsc(avaliado);
	}

	@Override
	@Deprecated
	public void save(Avaliacao avaliacao) {
	}

	@Override
	public List<Avaliacao> findByPageRequest(PageRequest pageRequest) {
		return this.physicalTestRepository.findAllByOrderByDataDesc(pageRequest).getContent();
	}

	@Override
	public void save(Avaliacao avaliacao, Avaliado avaliado, Status status) {
		avaliacao.setAvaliado(avaliado);
		avaliacao.setStatus(status);
		avaliacao.setAtivacao(Ativacao.ATIVA);
		avaliacao.setData(Calendar.getInstance());
		this.physicalTestRepository.save(avaliacao);
	}

	@Override
	public void update(Avaliacao avaliacao) {
		this.physicalTestRepository.save(avaliacao);
	}

	@Override
	public Avaliacao findById(Long id) {
		return this.physicalTestRepository.findById(id).get();
	}

	@Override
	public List<Avaliacao> findAll() {
		return (List<Avaliacao>) this.physicalTestRepository.findAll();
	}

	@Override
	public void delete(Avaliacao avaliacao) {
		this.physicalTestRepository.delete(avaliacao);
	}

	@Override
	public Avaliacao findByClientAndActivation(Avaliado avaliado, Ativacao ativacao) {
		return this.physicalTestRepository.findByAvaliadoAndAtivacao(avaliado, ativacao);
	}

	@Override
	public void disable(Avaliacao avaliacao) {
		avaliacao.setAtivacao(Ativacao.DESATIVA);
		this.update(avaliacao);
	}

}
