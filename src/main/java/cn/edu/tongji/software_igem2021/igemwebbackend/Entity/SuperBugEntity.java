package cn.edu.tongji.software_igem2021.igemwebbackend.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "super_bug", schema = "iGEM_database", catalog = "")
public class SuperBugEntity {
    private String seqNcbiId;
    private String genebankId;
    private Integer txid;
    private String txidRank;
    private String name;

    @Id
    @Column(name = "seq_ncbi_id")
    public String getSeqNcbiId() {
        return seqNcbiId;
    }

    public void setSeqNcbiId(String seqNcbiId) {
        this.seqNcbiId = seqNcbiId;
    }

    @Basic
    @Column(name = "genebank_id")
    public String getGenebankId() {
        return genebankId;
    }

    public void setGenebankId(String genebankId) {
        this.genebankId = genebankId;
    }

    @Basic
    @Column(name = "txid")
    public Integer getTxid() {
        return txid;
    }

    public void setTxid(Integer txid) {
        this.txid = txid;
    }

    @Basic
    @Column(name = "txid_rank")
    public String getTxidRank() {
        return txidRank;
    }

    public void setTxidRank(String txidRank) {
        this.txidRank = txidRank;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperBugEntity that = (SuperBugEntity) o;
        return Objects.equals(seqNcbiId, that.seqNcbiId) && Objects.equals(genebankId, that.genebankId) && Objects.equals(txid, that.txid) && Objects.equals(txidRank, that.txidRank) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqNcbiId, genebankId, txid, txidRank, name);
    }
}
