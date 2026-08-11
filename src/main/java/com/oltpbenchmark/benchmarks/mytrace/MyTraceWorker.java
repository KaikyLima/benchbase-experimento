package com.oltpbenchmark.benchmarks.mytrace;

import com.oltpbenchmark.api.Procedure.UserAbortException;
import com.oltpbenchmark.api.TransactionType;
import com.oltpbenchmark.api.Worker;
import com.oltpbenchmark.benchmarks.mytrace.procedures.GetUsuarios;
import com.oltpbenchmark.types.TransactionStatus;
import java.sql.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MyTraceWorker extends Worker<MyTraceBenchmark> {

  private static final Logger LOG = LoggerFactory.getLogger(MyTraceWorker.class);

  private final GetUsuarios procGetUsuarios;

  public MyTraceWorker(MyTraceBenchmark benchmarkModule, int id) {
    super(benchmarkModule, id);
    this.procGetUsuarios = this.getProcedure(GetUsuarios.class);
  }

  @Override
  protected TransactionStatus executeWork(Connection conn, TransactionType nextTrans)
      throws UserAbortException {

    LOG.debug("Executando GetUsuarios");

    try {
      procGetUsuarios.run(conn);
    } catch (Exception ex) {
      LOG.error(ex.getMessage(), ex);
    }

    return TransactionStatus.SUCCESS;
  }
}
